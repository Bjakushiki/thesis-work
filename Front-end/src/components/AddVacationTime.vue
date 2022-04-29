<template>
    <div>
        <div v-if="!submitted">
            <div class="mb-3">
                <label for="startDate" class="form-label">Start</label>
                <datetime format="YYYY-MM-DD" width="300px" v-model="vacationTime.startDate"></datetime>
            </div>
            <div class="mb-3">
                <label for="endDate" class="form-label">End</label>
                 <datetime format="YYYY-MM-DD" width="300px" v-model="vacationTime.endDate"></datetime>
            </div>
            <div class="mb-3">
                <label for="type" class="form-label">Type</label>
                <input type="text" class="form-control" id="type" required name="type" v-model="vacationTime.type">
            </div>
            <div class="mb-3">
                <button @click="saveVacationTime" class="btn btn-primary">Submit</button>
            </div>
        </div>
        <div v-else>
            <div class="alert alert-success" role="alert">
                Save Vacation successfully!
            </div>
            <button @click="newVacationTime" class="btn btn-primary">Add Vacation </button>
        </div>
    </div>
</template>

<script>
import VacationTimeDataService from '../services/VacationTimeDataService'
import datetime from 'vuejs-datetimepicker';

export default {
    components: { datetime },
    name: 'create-vacation-times',
    data() {
        return {
            vacationTime: {
                vacationId: this.$route.params.id,
                startDate: "",
                endDate: "",
                type: ""
            },
            submitted: false
        }
    },
    methods: {
        saveVacationTime() {
            var start = this.vacationTime.startDate;
            var end = this.vacationTime.endDate;
            var startd = start + 'T08:00:00.000Z'
            var endd = end + 'T16:00:00.000Z'

            var data = {
                vacationId: this.$route.params.id,
                startDate: startd, 
                endDate: endd, 
                type: this.vacationTime.type
            }
            VacationTimeDataService.create(data)
                .then(response => {
                    this.startDate = response.data
                    this.submitted = true;
                })
                .catch( e => {
                    alert(e)
                })
        },
        newVacationTime() {
            this.submitted = false
            this.user = {}
        }
    }
}
</script>