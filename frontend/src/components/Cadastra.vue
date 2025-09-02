<template>
  <div v-if="mostrar" class="modal-overlay">
    <div class="modal-content">
      <h2>Cadastrar Fornecedor</h2>

      <form class="formulario" @submit.prevent="cadastrarFornecedor">
        <div>
          <label>Nome:</label>
          <input type="text" v-model="novoFornecedor.nome" placeholder="Digite o nome" />
        </div>
        <div>
          <label>CPF/CNPJ:</label>
          <input type="text" v-model="novoFornecedor.cpfCnpj" placeholder="Digite o CPF ou CNPJ" />
        </div>
        <div>
          <label>CEP:</label>
          <input type="text" v-model="novoFornecedor.cep" placeholder="Digite o CEP" />
        </div>
        <div>
          <label>Email:</label>
          <input type="text" v-model="novoFornecedor.email" placeholder="Digite o e-mail" />
        </div>
        <div>
          <label>RG:</label>
          <input type="text" v-model="novoFornecedor.rg" placeholder="Digite o RG" />
        </div>
        <div>
          <label>Data de Nascimento</label>
          <input type="date" v-model="novoFornecedor.dataNascimento" placeholder="Digite a Data de Nascimento" />
        </div>
        <div class="botoes-form">
            <button type="submit" class="btn-form" id="btn-cadastrar">Cadastrar</button>
            <button class="btn-form" id="btn-fechar" @click="$emit('fechar')">Cancelar</button>
      </div>
      </form>
    </div>
  </div>
</template>

<script>

import EmpresaService from '../services/EmpresaService';

export default {
  name: "Cadastra",
  props: {
    mostrar: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      novoFornecedor: {
        nome: '',
        cpfCnpj: '',
        email: '',
        cep: '',
        rg: '',
        dataNascimento: ''
      }
    };
  },
  methods: {
    cadastrarFornecedor() {
        console.log("apertou")
        console.log(this.novoFornecedor)
      EmpresaService.createFornecedor(this.novoFornecedor)
        .then(() => {
          this.$emit('cadastrar');
          this.$emit('fechar');
        })
        .catch(err => {
          console.error('Erro ao cadastrar fornecedor:', err);
        });
    }
  }
};
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0,0,0,0.7);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 100;
}



input{
    background-color: #d9d9d9;
    color: black;
}

.modal-content {
  background: #f1f1f1;
  padding: 2rem;
  border-radius: 12px;
  width: 400px;
  color: black;
}

.formulario div {
  margin-bottom: 1rem;
  display: flex;
  flex-direction: column;
  text-align: left;
}

.btn-form {
  margin-top: 1rem;
  color: white;
  padding: 0.6rem 1rem;
  border: none;
  border-radius: 8px;
  cursor: pointer;
}

.botoes-form {
  display: flex;
  justify-content: space-between;
  margin-top: 1rem;
}

#btn-fechar {
  background: #dc3545;
}

#btn-fechar:hover {
  background: #c82333;
}

#btn-cadastrar {
  background: #007bff;
  margin-left: 5px;
}

#btn-cadastrar:hover {
  background: #0056b3;
}

</style>
