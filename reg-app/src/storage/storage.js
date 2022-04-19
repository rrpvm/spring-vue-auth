import Vuex from 'vuex';
//import axios from 'axios';
const storage = new Vuex.Store({
    state: {
        auth: {
            token: localStorage.getItem('jwtToken') || '',
            username: localStorage.getItem('username') || '',
        }
    },
    mutations: {
        setJwtToken(state, token) {
            localStorage.setItem('jwtToken', token);
            state.auth.token = token;
        },
        setUsernameToken(state, name) {
            localStorage.setItem('username', name);
            state.auth.username = name;
        },
    },
    actions: {

    }
});
export default storage;