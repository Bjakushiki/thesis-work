<template>
    <div>
        <table class="table">
            <thead>
                <tr>
                <th scope="col">Name</th>
                <th scope="col">Vacation</th>
                <th scope="col">Active Times</th>
                <th scope="col">Tasks</th>
                <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody v-for="(user, index) in users" :key="index">
                <tr>
                    <td>{{user.name}}</td>
                    <td><a :href="'/vacations/' + user.vacation.id" class="btn btn-primary">Show Vacation</a></td>
                    <td><a :href="'/activeTimes/' + user.id" class="btn btn-primary">Show Actiove times</a></td>
                    <td><a :href="'/tasks/' + user.id" class="btn btn-primary">Show Tasks</a></td>
                    <td><a :href="'/users/edit/' + user.id" class="btn btn-primary">Edit</a></td>
                </tr>
            </tbody>
        </table>
        <div class="mb-3">
                <button @click="createUser" class="btn btn-primary">Create User</button>
        </div>
    </div>
</template>

<script>
import UserDataService from '../services/UserDataService'

export default {
    name: 'users',
    data() {
        return {
            users: []
        }
    },
    methods: {
        retrieveUsers() {
            UserDataService.getAll()
                .then(response => {
                    this.users = response.data
                })
                .catch(e => {
                    alert(e)
                })
        },
        createUser(){
            this.$router.push({path: '/Admin/users/create'})
        }
    },
    
    mounted() {
        this.retrieveUsers()
    }
}
</script>
