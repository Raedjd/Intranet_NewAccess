import cookie from "js-cookie";
import axios from "axios";
export const authRoles = {
    sa: ['SA'], // Only Super Admin has access
    admin: ['SA', 'ADMIN'], // Only SA & Admin has access
    editor: ['SA', 'ADMIN', 'EDITOR'], // Only SA & Admin & Editor has access
    guest: ['SA', 'ADMIN', 'EDITOR', 'GUEST'], // Everyone has access
}


export const getToken=()=>{
    return cookie.get("jwt");
}

export const fetchUserData=(authRequest)=> {
    return axios({
        method: 'GET',
        url: `http://localhost:8082/user/findByToken`,
        headers: {
            'Authorization': 'Bearer ' + getToken()
        }
    })
}
export const fetchUsersData=(authRequest)=> {
    return axios({
        method: 'GET',
        url: `http://localhost:8082/user/findAll`,
        headers: {
            'Authorization': 'Bearer ' + getToken()
        }
    })
}

export const fetchDepartmentData=(authRequest)=> {
    return axios({
        method: 'GET',
        url: `http://localhost:8082/dep/findAll`,
        headers: {
            'Authorization': 'Bearer ' + getToken()
        }
    })
}

export const fetchProductsData=(authRequest)=> {
    return axios({
        method: 'GET',
        url: `http://localhost:8082/product/findAll`,
        headers: {
            'Authorization': 'Bearer ' + getToken()
        }
    })
}
export const fetchToolssData=(authRequest)=> {
    return axios({
        method: 'GET',
        url: `http://localhost:8082/tools/findAll`,
        headers: {
            'Authorization': 'Bearer ' + getToken()
        }
    })
}

export const fetchEventsData=(authRequest)=> {
    return axios({
        method: 'GET',
        url: `http://localhost:8082/event/findAll`,
        headers: {
            'Authorization': 'Bearer ' + getToken()
        }
    })
}

