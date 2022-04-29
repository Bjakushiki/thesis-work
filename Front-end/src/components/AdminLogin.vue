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
                <button @click="login" class="btn btn-primary">Login</button>
            </div>
            
        </div>
        <div v-else>
            <div class="alert alert-success" role="alert">
                Save successfully!
            </div>
            <button @click="back" class="btn btn-primary">Back</button>
        </div>
    </div>
</template>

<script>
import UserDataService from '../services/UserDataService'

export default {
    name: 'add-active-time',
    data() {
        return {
            user: {
                id: 0,
                name: "",
                passwd: ""
            },
            submitted: false
        }
    },
    methods: {
        login() {
            var data = {
                name: this.user.name,
                passwd: btoa(this.user.passwd)
            }
            UserDataService.adminLogin(data)
                .then(response => {
                    response.data
                    if(response.data != 0 && response.data != 9999){
                        this.$router.push({path: '/Admin/userList'}) 
                    }else if(response.data == 9999){
                        alert('You are not admin')
                        alert('Invalid username or password')
                    }else {
                        alert('Invalid username or password')
                    }
                })
                .catch( e => {
                    alert(e)
                })
           
            
        },
           
        back() {
            this.submitted = false
            this.user = {}
        }
    }
}
</script>