<template>
    <div>
        <table class="table">
            <thead>
                <tr>
                <th scope="col">Start</th>
                <th scope="col">End</th>
                <th scope="col">Type</th>
                <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody v-for="(vacationTime, index) in vacation.vacationTimeList" :key="index">
                <tr>
                    <td>{{new Date( Date.parse(vacationTime.start) ) }}</td>
                    <td>{{new Date( Date.parse(vacationTime.end) )}}</td>
                    <td>{{vacationTime.type}}</td>
                    <td><a :href="'/vacations/'+ vacation.id + '/edit/' + vacationTime.id" class="btn btn-primary">Edit</a></td>
                </tr>
            </tbody>
        </table>
        <div class="mb-3">
                <button @click="createVacations" class="btn btn-primary">Create Vacations</button>
        </div>
    </div>
</template>


<script>

import VacationTimeDataService from '../services/VacationTimeDataService'

export default {
    name: 'get-active-times',
    data() {
        return {
            vacation : null
        }
    },
    methods: {
        retrieveUsers(id) {
            VacationTimeDataService.get(id)
                .then(response => {
                    this.vacation = response.data
                })
                .catch(e => {
                    alert(e)
                })
        },
        createVacations(){
            this.$router.push({path: '/vacations/'+ this.$route.params.id + '/create'})
        }
    },
    
    mounted() {
        this.retrieveUsers(this.$route.params.id)
    }
}

</script>