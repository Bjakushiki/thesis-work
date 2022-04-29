import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/users',
            alias: '/Admin/userList',
            name: 'users',
            component: () => import('./components/UserList')
        },
        {
            path: '/users/create',
            alias: '/Admin/users/create',
            name: 'add-user',
            component: () => import('./components/AddUser')
        },
        {
            path: '/users/edit/:id',
            name: 'edit-user',
            component: () => import('./components/EditUser')
        },
        {
            path: '/',
            alias: '/addTime',
            name: 'add-active-time',
            component: () => import('./components/AddActiveTime')
        },
        {
            path: '/activeTimes/:id',
            name: 'get-active-times',
            component: () => import('./components/ActiveTimeList')
        },
        {
            path: '/activeTimes/:uid/edit/:id',
            name: 'edit-active-times',
            component: () => import('./components/EditActiveTime')
        },
        {
            path: '/vacations/:id',
            name: 'get-vacation-times',
            component: () => import('./components/VacationTimeList')
        },
        {
            path: '/vacations/:id/create',
            name: 'create-vacation-times',
            component: () => import('./components/AddVacationTime')
        },
        {
            path: '/vacations/:vid/edit/:id',
            name: 'edit-vacation-times',
            component: () => import('./components/EditVacationTime')
        },
        {
            path: '/Admin',
            name: 'admin-login',
            component: () => import('./components/AdminLogin')
        },
        {
            path: '/tasks/:rid/create',
            name: 'create-task',
            component: () => import('./components/AddTask')
        },
        {
            path: '/tasks/:rid',
            name: 'list-task',
            component: () => import('./components/TaskList')
        },
        {
            path: '/tasks/:rid/edit/:id',
            name: 'edit-task',
            component: () => import('./components/EditTask')
        }
    ]
})