<template>
  <div class="empresa-search">
    <div class="content-block"> 
      <h1>Desafio Full-Stack</h1>
      <input class="barra-pesquisa" v-model="query" placeholder="Digite nome fantasia ou CNPJ da empresa" @keyup.enter="buscar" />
      <div class="btn-radio"> 
        <label>
          <input type="radio" value="true" v-model="nameOrCnpj" />
          Nome
          <input type="radio" value="false" v-model="nameOrCnpj" />
          CNPJ
        </label>
        <button @click="buscar">Buscar</button>
      </div>

    </div>

    <ul v-if="empresas.length">
      <li v-for="empresa in empresas" :key="empresa.id">
        <router-link :to="`/empresa/${empresa.id}`">
          {{ empresa.nomeFantasia }}
          {{ formatarCNPJ(empresa.cnpj) }}
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
    },
    formatarCNPJ(cnpj) {
      if (!cnpj) return "";
        return cnpj
          .replace(/\D/g, "")
          .replace(/(\d{2})(\d)/, "$1.$2")
          .replace(/(\d{3})(\d)/, "$1.$2")
          .replace(/(\d{3})(\d{4})/, "$1/$2")
          .replace(/(\d{4})(\d{2})$/, "$1-$2");
    }
  }
}
</script>

<style scoped>

.empresa-search {
  max-width: 700px;
  margin: 2rem auto;
  padding: 2rem;
  background-color: rgb(19, 18, 18);
  border-radius: 12px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  font-family: Arial, sans-serif;
}

.content-block {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 1rem;
}

.content-block h1 {
  font-size: 3rem;
  color: #ffffff;
}

.barra-pesquisa {
  width: 100%;
  max-width: 500px;
  padding: 0.6rem 1rem;
  border: 1px solid #ccc;
  border-radius: 8px;
  outline: none;
  transition: border 0.3s;
}

.barra-pesquisa:focus {
  border: 1px solid #007bff;
}

button {
  padding: 0.6rem 1.2rem;
  border: none;
  background: #007bff;
  color: white;
  font-weight: bold;
  border-radius: 8px;
  cursor: pointer;
}

button:hover {
  background: #0056b3;
}

.btn-radio {
  display: flex;
  gap: 2rem;
  margin-top: 0.5rem;
  font-size: 0.95rem;
}

.btn-radio label {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

ul {
  list-style: none;
  padding: 0;
  margin-top: 2rem;
}

li {
  margin: 0.8rem 0;
  padding: 0.8rem;
  background: #d9d9d9;
  border-radius: 8px;
}

li:hover {
  transform: translateX(5px);
  background: #f1f1f1;
}

a {
  text-decoration: none;
  color: #333;
  font-weight: bold;
}

a:hover {
  color: #007bff;
}

</style>style
