<template>
  <div v-if="mostrar" class="modal-overlay">
    <div class="modal-content">
      <h2>Cadastrar Fornecedor</h2>

      <div class="btn-radio"> 
        <label>
          <input type="radio" value="true" v-model="ehPF" @click="resetForm"/>
          Pessoa Física
          <input type="radio" value="false" v-model="ehPF" @click="resetForm"/>
          Pessoa Jurídica
        </label>
      </div>

      <form class="formulario" @submit.prevent="cadastrarFornecedor">
        <div>
          <label>Nome:</label>
          <input type="text" v-model="novoFornecedor.nome" placeholder="Digite o nome" />
        </div>
        <div class="pessoa-fisica" v-if="ehPF=='true'">
          <div>
            <label>CPF:</label>
            <MaskInput  type="text" mask="###.###.###-##"
              v-model="novoFornecedor.cpfCnpj" placeholder="Digite o CPF" />
          </div>
        </div>
        <div class="pessoa-juridica" v-else>
          <div>
            <label>CNPJ:</label>
            <MaskInput type="text" mask="##.###.###/####-##" 
              v-model="novoFornecedor.cpfCnpj" placeholder="Digite o CNPJ" />
          </div>
        </div>
    
        <div>
          <label>CEP:</label>
          <MaskInput type="text" mask="##.###-###" 
            v-model="novoFornecedor.cep" placeholder="Digite o CEP" />
        </div>
        <div>
          <label>Email:</label>
          <input type="text" v-model="novoFornecedor.email" placeholder="Digite o e-mail" />
        </div>

        <div class="pessoa-fisica" v-if="ehPF=='true'">
          <div>
            <label>RG:</label>
            <MaskInput type="text" mask="AA-###.###.###"  
              v-model="novoFornecedor.rg" placeholder="Digite o RG" />
          </div>
          <div>
            <label>Data de Nascimento</label>
            <input type="date" v-model="novoFornecedor.dataNascimento" placeholder="Digite a Data de Nascimento" />
          </div>
        </div>

        <div class="botoes-form">
            <button type="submit" class="btn-form" id="btn-cadastrar">Cadastrar</button>
            <button class="btn-form" id="btn-fechar" @click="fecharFormulario">Cancelar</button>
      </div>
      <p v-if="erro" class="erro erro-interno">{{ erro }}</p>
      </form>
    </div>
  </div>
</template>

<script>

import EmpresaService from '../services/EmpresaService';
import { MaskInput } from 'vue-3-mask';

export default {
  name: "Cadastra",
  props: {
    mostrar: {
      type: Boolean,
      default: false
    }
  },
  components: {
    MaskInput,
  },
  data() {
    return {
      novoFornecedor: {
        nome: '',
        cpfCnpj: '',
        email: '',
        cep: '',
        rg: null,
        dataNascimento: ''
      },
      ehPF: "false",
      erro: null
    };
  },
  methods: {
    resetForm() {
      this.novoFornecedor = {
        nome: "",
        cpfCnpj: "",
        email: "",
        cep: "",
        rg: null,
        dataNascimento: ""
      };
      this.erros = null;
    },
    checkForm(){
      var error = null
      if(this.novoFornecedor.nome.length === 0){
        error = "Nome não prenchido!"
      }else if(this.novoFornecedor.email.length === 0){
        error = "E-mail não prenchido!"
      }else if(this.novoFornecedor.cep.length === 0){
        error = "CEP não prenchido!"
      }else if(this.novoFornecedor.cep.length < 10){
        error = "CEP incompleto!"
      }else{
        if(this.ehPF === "false"){
          if(this.novoFornecedor.cpfCnpj.length === 0){
            error = "CNPJ não prenchido!"
          }else if(this.novoFornecedor.cpfCnpj.length < 18){
            error = "CNPJ incompleto!"
          }
        }else{
          if(this.novoFornecedor.rg === null){
            error = "RG não prenchido!"
          }else if(this.novoFornecedor.rg.length < 13){
            error = "RG incompleto!"
          }else if(this.novoFornecedor.dataNascimento.length === 0){
            error = "Data de Nascimento não prenchida!"
          }else if(this.novoFornecedor.cpfCnpj.length === 0){
            error = "CPF não prenchido!"
          }else if(this.novoFornecedor.cpfCnpj.length < 14){
            error = "CPF incompleto!"
          }
        }
      }
      return error;
    },
    cadastrarFornecedor() {
      const payload = {
        fornecedor: this.novoFornecedor,
        empresaId: this.$route.params.id
      }
      this.erro = this.checkForm();
      console.log(this.erro)
      if (this.erro !== null) {return ;}
      EmpresaService.createFornecedor(payload)
        .then(() => {
          this.$emit('cadastrar');
          this.$emit('fechar');
          resetForm();
        })
        .catch(err => {
          console.error('Erro ao cadastrar fornecedor:', err);
          this.erro.internal = "Erro interno no servidor. Tente novamente.";
        });
    },
    fecharFormulario() {
      this.resetForm();
      this.$emit("fechar"); 
    },
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

div.pessoa-fisica, div.pessoa-juridica{
  margin-bottom: 0;
}

</style>
