<template>
    <div class="container">
        <!--
        <h1>Cadastro de Fornecedores</h1>
        <form @submit.prevent="adicionarFornecedor">
            <div>
                <label for="nome">Nome:</label>
                <input type="text" id="nome" v-model="fornecedor.nome" required />
            </div>
            <div>
                <label for="email">Email:</label>
                <input type="email" id="email" v-model="fornecedor.email" required />
            </div>
            <div>
                <label for="telefone">Telefone:</label>
                <input type="text" id="telefone" v-model="fornecedor.telefone" required />
            </div>
            <button type="submit">Adicionar Fornecedor</button>
        </form>
        -->

        <h1 class="text-center">Lista de Fornecedores</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>CPF/CNPJ</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>CEP</th>
                    <th>RG</th>
                    <th>Data de Nascimento</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="fornecedor in fornecedores" :key="fornecedor.id">
                    <td>{{ fornecedor.cpfCnpj }}</td>
                    <td>{{ fornecedor.nome }}</td>
                    <td>{{ fornecedor.email }}</td>
                    <td>{{ fornecedor.cep }}</td>
                    <td>{{ fornecedor.rg }}</td>
                    <td>{{ fornecedor.dataNascimento }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>

    import FornecedorService from '../services/FornecedorService';

    export default {
        name: 'Fornecedor',
        data() {
            return {
                fornecedores: []
            }
        },
        methods: {
            getFornecedores() {
                FornecedorService.getFornecedores()
                    .then(response => {
                        this.fornecedores = response.data;
                        console.log(response.data);
                    })
                    .catch(error => {
                        console.error("There was an error!", error);
                    });
            }
        },
        created() {
            this.getFornecedores();
        }
    };

</script>

<style scoped>
.container {
    max-width: 100%;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
    background-color: #f9f9f9;
    color: black;
}
</style>