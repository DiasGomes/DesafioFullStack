<template>
  <div v-if="empresa">
    <h1>Detalhes da Empresa</h1>
    <h2>{{ empresa.nomeFantasia }}</h2>
    <p><strong>CNPJ:</strong> {{ empresa.cnpj }}</p>
    <p><strong>CEP:</strong> {{ empresa.cep }}</p>
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
