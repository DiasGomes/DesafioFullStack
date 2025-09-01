import axios from 'axios';

const FRONECEDOR_API_URL = 'http://localhost:8080/fornecedor';

class FornecedorService {
    getFornecedores(){
        return axios.get(FRONECEDOR_API_URL);
    }
}

export default new FornecedorService();