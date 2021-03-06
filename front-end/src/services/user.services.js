// import config from 'config';
import { authHeader } from '../_helpers';
import axios from 'axios'

export const userService = {
    login,
    logout,
    getAll
};

function login(username, password) {
   
    const body = {'username': username, 'pwd': password};
    // const headers = { 'Content-Type': 'application/json' };
    const headers = authHeader();
    axios.post('/api/v1/user/login', body, {headers : headers})
    .then(handleResponse)
    .then(user => {
        // login successful if there's a jwt token in the response
        if (user.token) {
            // store user details and jwt token in local storage to keep user logged in between page refreshes
            localStorage.setItem('user', JSON.stringify(user));
        }

        return user;
        });
}

function logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('user');
}

function getAll() {

    // return fetch(`${config.apiUrl}/users`, requestOptions).then(handleResponse);
}

function handleResponse(response) {
    console.log(response);
        const data = response.data;
        if (!response.status == 200) {
            if (response.status === 401) {
                // auto logout if 401 response returned from api
                logout();
                location.reload(true);
            }

            const error = (data && data.message) || response.statusText;
            return Promise.reject(error);
        }

        return data;
}