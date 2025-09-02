<template>
  <div class="empresa-search">
    <h2>Pesquisar Empresas</h2>
    <input v-model="query" placeholder="Digite nome ou CNPJ" @keyup.enter="buscar" />
    <button @click="buscar">Buscar</button>

    <label>
      <input type="radio" value="true" v-model="nameOrCnpj" />
      Nome
      <input type="radio" value="false" v-model="nameOrCnpj" />
      CNPJ
    </label>

    <ul v-if="empresas.length">
      <li v-for="empresa in empresas" :key="empresa.id">
        <router-link :to="`/empresa/${empresa.id}`">
          {{ empresa.nomeFantasia }} - {{ empresa.cnpj }}
        </router-link>
      </li>
    </ul>

    <p v-else-if="buscou">Nenhuma empresa encontrada.</p>
  </div>
</template>

<script>
import EmpresaService from '../services/EmpresaService';

export default {
  name: 'Empresas',
  data() {
    return {
      query: '',
      empresas: [],
      nameOrCnpj: "true",
      buscou: false
    }
  },
  methods: {
    buscar() {
      if (!this.query) return;
      EmpresaService.searchEmpresas(this.query, this.nameOrCnpj)
        .then(response => {
          this.empresas = response.data;
          this.buscou = true;
        })
        .catch(error => {
          console.error("Erro ao buscar empresas:", error);
        });
    }
  }
}
</script>
