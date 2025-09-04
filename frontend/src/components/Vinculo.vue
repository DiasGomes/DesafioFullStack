<template>
  <div v-if="mostrar" class="modal-overlay">
    <div class="modal-content">
      <h2>Vincular Fornecedor</h2>

      <input v-model="query" id="pesquisa-fornecedor"
        placeholder="Digite nome, CPF ou CNPJ" @keyup.enter="buscar" />
      
      <div class="btn-radio"> 
        <label>
          <input type="radio" value="true" v-model="nameOrCnpj" />
          Nome
          <input type="radio" value="false" v-model="nameOrCnpj" />
          CPF/CNPJ
        </label>
        <button @click="buscar" id="btn-buscar">Buscar</button>
      </div>

      <div class="lista-fornecedores">
        <ul v-if="fornecedores.length">
            <li v-for="fornecedor in fornecedores" :key="fornecedor.id">
                <label>
                    <input type="radio" :value="fornecedor" v-model="fornecedorSelecionado"/>
                    {{ fornecedor.nome }} - {{ fornecedor.cpfCnpj }}
                </label>
            </li>
        </ul>
        
        <p v-else-if="buscou">Nenhuma fornecedor encontrado.</p>
        </div>

        <div id="btn-block">
            <div class="botoes-form">
                <button type="button" :disabled="!fornecedorSelecionado" @click="vincularFornecedor"
                    class="btn-form" id="btn-cadastrar">Vincular</button>
                <button class="btn-form" id="btn-fechar" @click="fecharVinculo">Cancelar</button>
            </div>
            <p v-if="erro" class="erro">{{ erro }}</p>
        </div>
    </div>
  </div>
</template>

<script>

import EmpresaService from '../services/EmpresaService';
import { MaskInput } from 'vue-3-mask';

export default {
  name: "Vinculo",
  props: {
    mostrar: {
      type: Boolean,
      default: false
    },
    empresa: null
  },
  components: {
    MaskInput,
  },
  data() {
    return {
      erro: null,
      nameOrCnpj: "true",
      fornecedores: [],
      buscou: false,
      fornecedorSelecionado: null,
      query: '',
    };
  },
  methods: {
    buscar() {
      if (!this.query) return;
      EmpresaService.searchFornecedores(this.query, this.nameOrCnpj)
        .then(response => {
          this.fornecedores = response.data;
          this.buscou = true;
        })
        .catch(error => {
          console.error("Erro ao buscar empresas:", error);
        });
    },
    vincularFornecedor() {
        const payload = {
                fornecedorId: this.fornecedorSelecionado.id,
                empresaId: this.$route.params.id
            }
        if (!this.fornecedorSelecionado){return;}
        if(this.fornecedorSelecionado.cpfCnpj.length === 14){
            this.erro = this.checkFornecedor();
            if (this.erro !== null) {return ;}
        }

        EmpresaService.vincularFornecedor(payload)
            .then(() => {
            this.$emit("vincular");
            this.fecharVinculo();
            this.resetForm();
            })
            .catch(err => {
                this.erro = "Erro interno no servidor. Tente novamente.";
                console.error('Erro ao cadastrar fornecedor:', err);
                if(err.name === "AxiosError"){
                    this.erro = "Erro! A empresa já tem esse fornecedor";
                }
            });
    },
    resetForm() {
      this.fornecedorSelecionado = null;
      this.erro = null;
      this.nameOrCnpj = "true";
      this.fornecedores = [];
      this.buscou = false;
      this.query = '';
    },
    checkFornecedor(){
        var error = null
        var cepResponse = this.httpGet(this.empresa.cep)
        var idade = this.calcularIdade(this.fornecedorSelecionado.dataNascimento)
        if((cepResponse.uf === "PR") && (idade < 18)){
            error = "Empresa do Paraná, não pode cadastrar um fornecedor pessoa física menor de idade"
        }
        return error;
    },
    fecharVinculo() {
      this.resetForm();
      this.$emit("fechar"); 
    },
    httpGet(cep)
    {
        var xmlHttp = new XMLHttpRequest();
        var cepOnlyNumbers = cep.replace("-", "")
        var theUrl = "http://viacep.com.br/ws/"+cepOnlyNumbers+"/json/"
        xmlHttp.open( "GET", theUrl, false );
        xmlHttp.send( null );
        return JSON.parse(xmlHttp.responseText);
    },
    calcularIdade(dataNascimentoStr) {
        const partes = dataNascimentoStr.split("-");
        const dia = parseInt(partes[2], 10);
        const mes = parseInt(partes[1], 10) - 1; 
        const ano = parseInt(partes[0], 10);

        const dataNascimento = new Date(ano, mes, dia);
        const hoje = new Date();

        let idade = hoje.getFullYear() - dataNascimento.getFullYear();
        const mesAtual = hoje.getMonth();
        const diaAtual = hoje.getDate();

        if (mesAtual < mes || (mesAtual === mes && diaAtual < dia)) {
            idade--;
        }

        return idade;
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

.modal-content {
  background: #f1f1f1;
  padding: 2rem;
  border-radius: 12px;
  width: 400px;
  color: black;
}

#pesquisa-fornecedor {
  width: 90%;
  max-width: 500px;
  padding: 0.6rem 1rem;
  border: 1px solid #ccc;
  border-radius: 8px;
  outline: none;
  transition: border 0.3s;
  margin-bottom: 15px;
  background-color: white;
  color: black;
}

.barra-pesquisa:focus {
  border: 1px solid #007bff;
}

#btn-buscar {
  padding: 0.6rem 1.2rem;
  border: none;
  background: #007bff;
  color: white;
  font-weight: bold;
  border-radius: 8px;
  cursor: pointer;
  margin-left: 20px;
}

#btn-buscar:hover {
  background: #0056b3;
}

.lista-fornecedores {
  max-height: 250px;
  overflow-y: auto; 
  padding: 0.5rem;
  border-radius: 6px;
}

.lista-fornecedores::-webkit-scrollbar {
  width: 10px;
}


ul {
  list-style: none;
  padding: 0;
  margin-top: 2rem;
}

li {
  margin: 0.8rem 0;
  padding: 0.8rem;
  background: white;
  border-radius: 8px;
}

li:hover {
  transform: translateX(5px);
  background: #b8b8b8;
}

#btn-block div {
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

.erro{
  color: #dc3545;
  font-weight: bold;
}

</style>
