import axios from 'axios';

const EMPRESA_API_URL = 'http://localhost:8080/home';

class EmpresaService {
    searchEmpresas(query, nameOrCnpj) {
        return axios.get(`${EMPRESA_API_URL}/search`, {
            params: { q: query, noc: nameOrCnpj }
        });
    }
}

export default new EmpresaService();