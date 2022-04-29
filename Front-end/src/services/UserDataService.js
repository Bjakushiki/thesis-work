import http from '../http-common'

class UserDataService {
    getAll() {
        return http.get('/admin/user/')
    }

    get(id) {
        return http.get(`/admin/user/get-by-id/${id}`)
    }

    create(data) {
        return http.put('/admin/user/create', data)
    }

    update(id, data) {
        return http.put(`/admin/user/update/${id}`, data)
    }

    delete(id) {
        return http.get(`/admin/user/delete-by-id/${id}`)
    }
    login(data){
        return http.put(`/user/login`, data) 
    }
    adminLogin(data){
        return http.put(`/admin/user/login`, data) 
    }

    arrival(id){
        return http.get(`/user/arrival/${id}`)
    }
    departure(id){
        return http.get(`/user/departure/${id}`)
    }
}

export default new UserDataService()
