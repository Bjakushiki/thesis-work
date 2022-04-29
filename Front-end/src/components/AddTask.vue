<template>
    <div>
        <div v-if="!submitted">
            <div class="mb-3">
                <label for="name" class="form-label">Task Name</label>
                <input type="text" class="form-control" id="name" required name="name" v-model="task.name">
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <input type="text" class="form-control" id="description" required name="description" v-model="task.description">
            </div>
            <div class="mb-3">
                <button @click="saveTask" class="btn btn-primary">Submit</button>
            </div>
        </div>
        <div v-else>
            <div class="alert alert-success" role="alert">
                Save Task successfully!
            </div>
            <button @click="newTask" class="btn btn-primary">Add New Task</button>
        </div>
    </div>
</template>

<script>
import TaskDataService from '../services/TaskDataService'

export default {
    name: 'create-task',
    data() {
        return {
            task: {
                name: "",
                description: "",
                reporterId: 0,
                assigneeId: 0
            },
            submitted: false
        }
    },
    methods: {
        saveTask() {
            var data = {
                name: this.task.name,
                description: this.task.description,
                reporterId: this.$route.params.rid,
                assigneeId: this.$route.params.rid
            }
            TaskDataService.create(data)
                .then(response => {
                    this.task.name = response.data
                    this.submitted = true;
                })
                .catch( e => {
                    alert(e)
                })
        },
        newTask() {
            this.submitted = false
            this.user = {}
        }
    }
}
</script>