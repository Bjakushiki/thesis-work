import http from '../http-common'

class VacationTimeDataService {

    get(id) {
        return http.get(`/vacation/get-by-id/${id}`)
    }
    getVacationTime(id) {
        return http.get(`/admin/vacationTime/get-by-id/${id}`)
    }

    delete(vid,id) {
        return http.get(`/admin/vacationTime/delete-by-id/${vid}/${id}`)
    }

    update(vid,id,data){
        return http.put(`/admin/vacationTime/update-by-id/${vid}/${id}`,data)
    }
    create(data){
        return http.put(`/vacationTime/create `,data)
    }

}

export default new VacationTimeDataService()