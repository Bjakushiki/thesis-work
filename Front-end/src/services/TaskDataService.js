import http from '../http-common'

class TaskDataService {

    get(id) {
        return http.get(`/task/get-by-user-id/${id}`)
    }
    getTask(id) {
        return http.get(`/admin/task/get-by-id/${id}`)
    }

    delete(id) {
        return http.get(`/admin/task/delete-by-id/${id}`)
    }

    update(id,data){
        return http.put(`/admin/task/update/${id}`,data)
    }

    create(data){
        return http.put(`/task/create `,data)
    }
}

export default new TaskDataService()