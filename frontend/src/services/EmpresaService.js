import axios from 'axios';

const apiUrl = import.meta.env.VITE_API_URL
const HOME_API_URL = apiUrl + '/home';
const EMPRESA_API_URL = apiUrl + '/empresa';

class EmpresaService {
    getEmpresaById(id) {
        return axios.get(`${EMPRESA_API_URL}/${id}`);
    }

    searchEmpresas(query, nameOrCnpj) {
        return axios.get(`${HOME_API_URL}/search`, {
            params: { q: query, noc: nameOrCnpj }
        });
    }

    createFornecedor(payload) {
        return axios.post(`${EMPRESA_API_URL}/${payload.empresaId}`, payload.fornecedor);
    }

}

export default new EmpresaService();