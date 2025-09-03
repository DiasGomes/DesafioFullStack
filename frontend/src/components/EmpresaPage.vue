<template>
  <div v-if="empresa">

    <div class="btn" id="btn-home">
      <router-link to="/">Home</router-link>
    </div>

    <div class="btn" id="btn-cadastrar">
      <button @click="abrirFormulario">Cadastrar Fornecedor</button>
    </div>

    <div class="content-block"> 
      <div> 
        <h1>{{ empresa.nomeFantasia }}</h1>
        <p>
          <strong>CNPJ:</strong> 
          {{ formatarCpfCnpj(empresa.cnpj) }}
          <strong>CEP:</strong>
          {{ formatarCEP(empresa.cep) }}
        </p>
      </div>
      
      <div class="body-block"> 
      <ul v-if="empresa.fornecedores.length">
        <li v-for="fornecedor in empresa.fornecedores" :key="fornecedor.id">
          <table>
            <tbody class="block-fornecedor">
              <tr> 
                <td><strong>Fornecedor:</strong></td>
                <td>{{ fornecedor.nome }}</td>
              </tr>
              <tr> 
                <td><strong>CPF/CNPJ:</strong></td>  
                <td>{{ formatarCpfCnpj(fornecedor.cpfCnpj) }}</td>
              </tr>
              <tr>
                <td><strong>E-mail:</strong></td>
                <td>{{ fornecedor.email }}</td>
              </tr>
              <tr> 
                <td><strong>CEP:</strong></td> 
                <td>{{ formatarCEP(fornecedor.cep) }}</td>
              </tr>
              <tr v-if="fornecedor.rg"> 
                <td><strong>RG:</strong></td> 
                <td>{{ fornecedor.rg }}</td>
              </tr>
              <tr v-if="fornecedor.dataNascimento"> 
                <td><strong>Data de Nascimento:</strong></td>
                <td>{{ fornecedor.dataNascimento }}</td>
              </tr>
            </tbody>
          </table>
        </li>
      </ul>
    </div>

    </div>

    <Cadastra
      :mostrar="mostrarFormulario" 
      @fechar="fecharFormulario" 
      @cadastrar="recarregarEmpresa"
    />
  </div>
</template>

<script>
import EmpresaService from '../services/EmpresaService';
import Cadastra from './Cadastra.vue';

export default {
  components: { Cadastra },
  props: ['id'],
  data() {
    return {
      empresa: null,
      mostrarFormulario: false
    };
  },
  created() {
    EmpresaService.getEmpresaById(this.id)
      .then(res => {
        this.empresa = res.data;
      })
      .catch(err => console.error(err));
  },
  methods: {
    formatarCpfCnpj(c) {
      if(c.length == 11){
        // CPF
        return c
          .replace(/\D/g, "")
          .replace(/(\d{3})(\d)/, "$1.$2")
          .replace(/(\d{3})(\d)/, "$1.$2")
          .replace(/(\d{3})(\d{2})$/, "$1-$2");
      }else if(c.length == 14){
        // CNPJ
        return c
          .replace(/\D/g, "")
          .replace(/(\d{2})(\d)/, "$1.$2")
          .replace(/(\d{3})(\d)/, "$1.$2")
          .replace(/(\d{3})(\d)/, "$1/$2")
          .replace(/(\d{4})(\d{2})/, "$1-$2");

      }
      return "";
    },
    formatarCEP(cep) {
      if (!cep) return "";
        return cep
          .replace(/\D/g, "")
          .replace(/(\d{2})(\d)/, "$1.$2")
          .replace(/(\d{3})(\d{2})/, "$1-$2");
    },
    abrirFormulario() {
      this.mostrarFormulario = true;
    },
    fecharFormulario() {
      this.mostrarFormulario = false;
    },
    recarregarEmpresa() {
      EmpresaService.getEmpresaById(this.id)
        .then(res => {
          this.empresa = res.data;
        })
        .catch(err => console.error(err));
    }
  }
};
</script>

<style scoped>
#btn-home {
  position: absolute;
  top: 2rem;
  left: 1rem;
}

#btn-cadastrar {
  position: absolute;
  top: 2rem;
  right: 1rem;
}

.btn a, button {
  text-decoration: none;
  padding: 0.6rem 1rem;
  background: #007bff;
  color: #fff;
  border-radius: 8px;
  font-weight: bold;
}

.btn a:hover, button:hover {
  background: #0056b3;
}

.content-block {
  max-width: 800px;
  margin: 1rem auto;
  padding: 1.5rem;
  background-color: rgb(19, 18, 18);
  border-radius: 12px;
  box-shadow: 0 3px 8px rgba(0, 0, 0, 0.08);
  text-align: center;
}

.content-block h1 {
  font-size: 2rem;
  color: white;
  margin-bottom: 1rem;
}

.content-block p {
  margin: 0.4rem 0;
  font-size: 1.1rem;
  color: white;
}

.body-block {
  max-width: 1000px;
  margin: 2rem auto;
  display: grid;
  column-count: 1;
  gap: 1.2rem;
}

.body-block ul {
  list-style: none;
  padding: 0;
  margin: 0;
  grid-column: 1 / -1;
  display: contents;
}

.body-block li {
  background-color: rgb(19, 18, 18);
  border: 1px solid #eee;
  border-radius: 10px;
  padding: 1rem;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.05);
  transition: transform 0.2s, box-shadow 0.2s;
  justify-content: center;
}

.body-block li:hover {
  transform: translateY(-3px);
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.body-block li strong {
  color: #ffffff;
}

.block-fornecedor {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
  margin: 0 auto;         
  max-width: 600px;
  text-align: center;
}

.block-fornecedor .row {
  display: grid;
  grid-template-columns: 150px 1fr;
  gap: 1rem;
  justify-content: center;
  align-items: center;
}

.block-fornecedor strong {
  color: #ffffff;
  text-align: right; 
}

</style>
