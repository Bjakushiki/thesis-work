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
                <button @click="arrivalUser" class="btn btn-primary">Arrival</button>
            </div>
            <div class="mb-3">
                <button @click="departureUser" class="btn btn-primary">Departure</button>
            </div>
            <div class="mb-3">
                <button @click="showVacations" class="btn btn-primary">Show Vacations</button>
            </div>
            <div class="mb-3">
                <button @click="showTasks" class="btn btn-primary">Show Tasks</button>
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
        arrivalUser() {
            var data = {
                name: this.user.name,
                passwd: btoa(this.user.passwd)
            }
            UserDataService.login(data)
                .then(response => {
                     UserDataService.arrival(response.data)
                        .then(response => {
                            response.data
                            this.submitted = true
                         })
                        .catch( e => {
                            alert(e)
                        })
                })
                .catch( e => {
                    alert(e)
                })
           
            
        },
        departureUser() {
            var data = {
                name: this.user.name,
                passwd: btoa(this.user.passwd)
            }
            UserDataService.login(data)
                .then(response => {
                     UserDataService.departure(response.data)
                        .then(response => {
                            response.data
                            this.submitted = true
                         })
                        .catch( e => {
                            alert(e)
                        })
                })
                .catch( e => {
                    alert(e)
                })
           
            
        },
        showVacations(){
            var data = {
                name: this.user.name,
                passwd: btoa(this.user.passwd)
            }
                UserDataService.login(data)
                .then(response => { 
                    UserDataService.get(response.data)
                        .then(response => {
                            this.$router.push({path: '/vacations/'+ response.data.vacation.id})
                        })
                        .catch(e => {
                            alert(e)
                        })
                })
                .catch( e => {
                    alert(e)
                })


        },
        showTasks(){
            var data = {
                name: this.user.name,
                passwd: btoa(this.user.passwd)
            }
                UserDataService.login(data)
                .then(response => { 
                    UserDataService.get(response.data)
                        .then(response => {
                            this.$router.push({path: '/tasks/'+ response.data.id})
                        })
                        .catch(e => {
                            alert(e)
                        })
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