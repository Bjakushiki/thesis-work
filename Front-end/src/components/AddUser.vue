<template>
    <div>
        <div v-if="!submitted">
            <div class="mb-3">
                <label for="name" class="form-label">Username</label>
                <input type="text" class="form-control" id="name" required name="name" v-model="user.name">
            </div>
            <div class="mb-3">
                <label for="passwd" class="form-label">Password</label>
                <input type="text" class="form-control" id="passwd" required name="passwd" v-model="user.passwd">
            </div>
            <div class="mb-3">
                <button @click="saveUser" class="btn btn-primary">Submit</button>
            </div>
        </div>
        <div v-else>
            <div class="alert alert-success" role="alert">
                Save User successfully!
            </div>
            <button @click="newUser" class="btn btn-primary">Add New User</button>
        </div>
    </div>
</template>

<script>
import UserDataService from '../services/UserDataService'

export default {
    name: 'add-user',
    data() {
        return {
            user: {
                name: "",
                passwd: ""
            },
            submitted: false
        }
    },
    methods: {
        saveUser() {
            var data = {
                name: this.user.name,
                passwd: btoa(this.user.passwd)
            }
            UserDataService.create(data)
                .then(response => {
                    this.user.id = response.data.id
                    this.submitted = true;
                })
                .catch( e => {
                    alert(e)
                })
        },
        newUser() {
            this.submitted = false
            this.user = {}
        }
    }
}
</script>
