<template>
    <div v-if="currentUser">
        <div class="mb-3">
                <label for="arrival" class="form-label">Username</label>
                <input type="text" class="form-control" id="arrival" required name="arrival" v-model="currentUser.name">
            </div>
            <div class="mb-3">
                <label for="departure" class="form-label">Password</label>
                <input type="text" class="form-control" id="departure" required name="departure" v-model="currentUser.passwd">
            </div>
           
            <div class="mb-3">
                <button @click="updateUser" class="btn btn-primary me-3">Update</button>
                <button @click="deleteUser" class="btn btn-danger">Delete</button>
            </div>
             <div class="alert alert-success" role="alert" v-if="message">
                {{message}}
            </div>
    </div>
</template>

<script>
import UserDataService from '../services/UserDataService'

export default {
    name: 'edit-user',
    data() {
        return {
            currentUser: null,
            message: ''
        }
    },
    methods: {
        getUser(id) {
            UserDataService.get(id)
                .then(response => {
                    this.currentUser = response.data
                })
                .catch(e => {
                    alert(e)
                })
        },
        updateUser() {
            this.currentUser.passwd = btoa(this.currentUser.passwd);
            UserDataService.update(this.$route.params.id, this.currentUser)
                .then(() => {
                    this.message = 'The User was updated successfully!'
                })
                .catch(e => {
                    alert(e)
                })
        },
        deleteUser() {
            UserDataService.delete(this.$route.params.id)
                .then(() => {
                    this.$router.push({path: '/users/'})
                })
                .catch(e => {
                    alert(e)
                })
        }
    },
    mounted() {
        this.getUser(this.$route.params.id)
    }
}
</script>
