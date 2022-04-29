<template>
    <div>
        <table class="table">
            <thead>
                <tr>
                <th scope="col">Arrival</th>
                <th scope="col">Departure</th>
                <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody v-for="(activeTimes, index) in user.activeTimes" :key="index">
                <tr>
                    <td>{{new Date( Date.parse(activeTimes.arrival) ) }}</td>
                    <td>{{new Date( Date.parse(activeTimes.departure) )}}</td>
                    <td><a :href="'/activeTimes/'+ user.id + '/edit/' + activeTimes.id" class="btn btn-primary">Edit</a></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>


<script>

import UserDataService from '../services/UserDataService'

export default {
    name: 'get-active-times',
    data() {
        return {
            user : null
        }
    },
    methods: {
        retrieveUsers(id) {
            UserDataService.get(id)
                .then(response => {
                    this.user = response.data
                })
                .catch(e => {
                    alert(e)
                })
        }
        
    },
    
    mounted() {
        this.retrieveUsers(this.$route.params.id)
    }
}

</script>




