<template>
    <div v-if="currentTask">
            <div class="mb-3">
                <label for="start" class="form-label">Name</label>
                <input type="text" class="form-control" id="start" required name="start" v-model="currentTask.name">
            </div>
            <div class="mb-3">
                <label for="start" class="form-label">Description</label>
                <input type="text" class="form-control" id="start" required name="start" v-model="currentTask.description">
            </div>
            <div class="mb-3">
                <label for="start" class="form-label">Start</label>
                <datetime format="YYYY-MM-DD" width="300px" v-model="currentTask.start"></datetime>
            </div>
            <div class="mb-3">
                <label for="end" class="form-label">End</label>
                 <datetime format="YYYY-MM-DD" width="300px" v-model="currentTask.end"></datetime>
            </div>
            <div class="mb-3">
                <label for="type" class="form-label">Reporter</label>
                <input type="text" class="form-control" id="type" required name="type" v-model="currentTask.reporter.name">
            </div>
            <div class="mb-3">
                <label for="type" class="form-label">Assignee</label>
                <input type="text" class="form-control" id="type" required name="type" v-model="currentTask.assignee.name">
            </div>
            <div class="mb-3">
                <label for="type" class="form-label">Status</label>
                <input type="text" class="form-control" id="type" required name="type" v-model="currentTask.status">
            </div>
           
            <div class="mb-3">
                <button @click="updateTask" class="btn btn-primary me-3">Update</button>
                <button @click="deleteTask" class="btn btn-danger">Delete</button>
            </div>
             <div class="alert alert-success" role="alert" v-if="message">
                {{message}}
            </div>
    </div>
</template>

<script>
import TaskDataService from '../services/TaskDataService'
import datetime from 'vuejs-datetimepicker';
import moment from 'moment'

export default {
    name: 'edit-task',
    components: { datetime },
    data() {
        return {
            currentTask: null,
            message: ''
        }
    },
    methods: {
        getTask(id) {
           TaskDataService.getTask(id)
                .then(response => {
                    this.currentTask = response.data
                    var sdate = moment(this.currentTask.start);
                    var sdateComponent = sdate.utc().format('YYYY-MM-DD');
                    this.currentTask.start = sdateComponent
                    var edate = moment(this.currentTask.end);
                    var edateComponent = edate.utc().format('YYYY-MM-DD');
                    this.currentTask.end = edateComponent
                })
                .catch(e => {
                    alert(e)
                })
        },
        updateTask() {
            var start = this.currentTask.start;
            var end = this.currentTask.end;
            var startd = start + 'T08:00:00.000Z'
            var endd = end + 'T16:00:00.000Z'
            this.currentTask.endDate = endd
            this.currentTask.startDate = startd

            TaskDataService.update(this.$route.params.id, this.currentTask)
                .then(() => {
                    this.message = 'The Task was updated successfully!'
                })
                .catch(e => {
                    alert(e)
                })
        },
        deleteTask() {
            TaskDataService.delete(this.$route.params.id)
                .then(() => {
                    this.$router.push({path: '/tasks/'+ this.$route.params.rid})
                })
                .catch(e => {
                    alert(e)
                })
        }
    },
    mounted() {
        this.getTask(this.$route.params.id)
    }
}
</script>