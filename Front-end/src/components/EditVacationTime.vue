<template>
    <div v-if="currentVacationTime">
        <div class="mb-3">
                <label for="start" class="form-label">Start</label>
                <datetime format="YYYY-MM-DD" width="300px" v-model="currentVacationTime.start"></datetime>
                
            </div>
            <div class="mb-3">
                <label for="end" class="form-label">End</label>
                 <datetime format="YYYY-MM-DD" width="300px" v-model="currentVacationTime.end"></datetime>
                
            </div>
            <div class="mb-3">
                <label for="type" class="form-label">Type</label>
                <input type="text" class="form-control" id="type" required name="type" v-model="currentVacationTime.type">
            </div>
           
            <div class="mb-3">
                <button @click="updateVacationTime" class="btn btn-primary me-3">Update</button>
                <button @click="deleteVacationTime" class="btn btn-danger">Delete</button>
            </div>
             <div class="alert alert-success" role="alert" v-if="message">
                {{message}}
            </div>
    </div>
</template>

<script>
import VacationTimeDataService from '../services/VacationTimeDataService'
import datetime from 'vuejs-datetimepicker';
import moment from 'moment'

export default {
    name: 'edit-active-time',
    components: { datetime },
    data() {
        return {
            currentVacationTime: null,
            message: ''
        }
    },
    methods: {
        getVacationTime(id) {
           VacationTimeDataService.getVacationTime(id)
                .then(response => {
                    this.currentVacationTime = response.data
                    var sdate = moment(this.currentVacationTime.start);
                    var sdateComponent = sdate.utc().format('YYYY-MM-DD');
                    this.currentVacationTime.start = sdateComponent
                    var edate = moment(this.currentVacationTime.end);
                    var edateComponent = edate.utc().format('YYYY-MM-DD');
                    this.currentVacationTime.end = edateComponent
                })
                .catch(e => {
                    alert(e)
                })
        },
        updateVacationTime() {
            var start = this.currentVacationTime.start;
            var end = this.currentVacationTime.end;
            var startd = start + 'T08:00:00.000Z'
            var endd = end + 'T16:00:00.000Z'
            this.currentVacationTime.end = endd
            this.currentVacationTime.start = startd
            VacationTimeDataService.update(this.$route.params.vid,this.$route.params.id, this.currentVacationTime)
                .then(() => {
                    this.message = 'The Vacation Time was updated successfully!'
                })
                .catch(e => {
                    alert(e)
                })
        },
        deleteVacationTime() {
            VacationTimeDataService.delete(this.$route.params.vid, this.$route.params.id)
                .then(() => {
                    this.$router.push({path: '/vacations/'+ this.$route.params.vid})
                })
                .catch(e => {
                    alert(e)
                })
        }
    },
    mounted() {
        this.getVacationTime(this.$route.params.id)
    }
}
</script>
