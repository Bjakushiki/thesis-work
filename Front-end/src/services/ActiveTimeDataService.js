import http from '../http-common'

class ActiveTimeDataService {

    get(id) {
        return http.get(`admin/activeTime/get-by-id/${id}`)
    }

    delete(uid,id) {
        return http.get(`/admin/activeTime/delete-by-id/${uid}/${id}`)
    }

    update(uid,id,data){
        return http.put(`/admin/activeTime/update-by-id/${uid}/${id}`,data)
    }
}

export default new ActiveTimeDataService()