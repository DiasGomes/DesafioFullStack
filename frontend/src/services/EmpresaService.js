import axios from 'axios';

const HOME_API_URL = 'http://localhost:8080/home';
const EMPRESA_API_URL = 'http://localhost:8080/empresa';

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