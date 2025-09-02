<template>
  <div v-if="empresa">
    <div class="btn-home">
      <router-link to="/">Home</router-link>
    </div>

    <h1>Detalhes da Empresa</h1>
    <h2>{{ empresa.nomeFantasia }}</h2>
    <p><strong>CNPJ:</strong> {{ empresa.cnpj }}</p>
    <p><strong>CEP:</strong> {{ empresa.cep }}</p>

    <ul v-if="empresa.fornecedores.length">
      <li v-for="fornecedor in empresa.fornecedores" :key="fornecedor.id">
          {{ fornecedor.nome }} - {{ fornecedor.cpfCnpj }} - {{ fornecedor.email}}
          {{ fornecedor.cep }} - {{ fornecedor.rg }} - {{ fornecedor.dataNascimento }}
      </li>
    </ul>
  </div>
</template>

<script>
import EmpresaService from '../services/EmpresaService';

export default {
  props: ['id'],
  data() {
    return {
      empresa: null
    };
  },
  created() {
    EmpresaService.getEmpresaById(this.id)
      .then(res => {
        this.empresa = res.data;
      })
      .catch(err => console.error(err));
  }
};
</script>
