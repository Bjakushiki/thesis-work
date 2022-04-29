<template>
    <div v-if="currentActiveTime">
        <div class="mb-3">
                <label for="arrival" class="form-label">Arrival</label>

                <input type="text" class="form-control" id="arrival" required name="arrival" v-model="currentActiveTime.arrival">
            </div>
            <div class="mb-3">
                <label for="departure" class="form-label">Departure</label>
                
                <input type="text" class="form-control" id="departure" required name="departure" v-model="currentActiveTime.departure">
            </div>
           
            <div class="mb-3">
                <button @click="updateActiveTime" class="btn btn-primary me-3">Update</button>
                <button @click="deleteActiveTime" class="btn btn-danger">Delete</button>
            </div>
             <div class="alert alert-success" role="alert" v-if="message">
                {{message}}
            </div>
    </div>
</template>

<script>
import ActiveTimeDataService from '../services/ActiveTimeDataService'


export default {
    name: 'edit-active-time',
    data() {
        return {
            currentActiveTime: null,
            message: ''
        }
    },
    methods: {
        getActiveTime(id) {
            ActiveTimeDataService.get(id)
                .then(response => {
                    this.currentActiveTime = response.data
                })
                .catch(e => {
                    alert(e)
                })
        },
        updateActiveTime() {
            ActiveTimeDataService.update(this.$route.params.uid,this.$route.params.id, this.currentActiveTime)
                .then(() => {
                    this.message = 'The Active Time was updated successfully!'
                })
                .catch(e => {
                    alert(e)
                })
        },
        deleteActiveTime() {
            ActiveTimeDataService.delete(this.$route.params.uid, this.$route.params.id)
                .then(() => {
                    this.$router.push({path: '/activeTimes/'+ this.$route.params.uid})
                })
                .catch(e => {
                    alert(e)
                })
        }
    },
    mounted() {
        this.getActiveTime(this.$route.params.id)
    }
}
</script>
