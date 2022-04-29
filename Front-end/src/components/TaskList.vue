<template>
    <div>
        <table class="table">
            <thead>
                <tr>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <th scope="col">Start</th>
                <th scope="col">End</th>
                <th scope="col">Reporter</th>
                <th scope="col">Assignee</th>
                <th scope="col">Status</th>
                <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody v-for="(task, index) in tasks" :key="index">
                <tr>
                    <td>{{task.name}}</td>
                    <td>{{task.description}}</td>
                    <td>{{new Date( Date.parse(task.startDate) ) }}</td>
                    <td>{{new Date( Date.parse(task.endDate) )}}</td>
                    <td>{{task.reporter.name}}</td>
                    <td>{{task.assignee.name}}</td>
                    <td>{{task.status}}</td>
                    <td><a :href="'/tasks/'+ task.reporter.id + '/edit/' + task.id" class="btn btn-primary">Edit</a></td>
                </tr>
            </tbody>
        </table>
        <div class="mb-3">
                <button @click="createTasks" class="btn btn-primary">Create Tasks</button>
        </div>
    </div>
</template>


<script>

import TaskDataService from '../services/TaskDataService'

export default {
    name: 'get-tasks',
    data() {
        return {
            tasks : null
        }
    },
    methods: {
        retrieveTasks(id) {
           TaskDataService.get(id)
                .then(response => {
                    this.tasks = response.data
                })
                .catch(e => {
                    alert(e)
                })
        },
        createTasks(){
            this.$router.push({path: '/tasks/'+ this.$route.params.rid + '/create'})
        }
    },
    
    mounted() {
        this.retrieveTasks(this.$route.params.rid)
    }
}

</script>