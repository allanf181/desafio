(ns cc.model)

(defn uuid [] (java.util.UUID/randomUUID))

(defn novo-cliente [nome cpf email]
  {:cliente/nome  nome
   :cliente/cpf   cpf
   :cliente/email email})

(defn novo-cartao [numero cvv validade limite cpf-cliente]
  {:cartao/numero   numero
   :cartao/cvv      cvv
   :cartao/validade validade
   :cartao/limite   limite
   :cartao/cliente  {:cliente/cpf cpf-cliente}})

(defn nova-compra [data valor estabelecimento categoria numero-cartao]
  {:compra/id              (uuid)
   :compra/data            data
   :compra/valor           valor
   :compra/estabelecimento estabelecimento
   :compra/categoria       categoria
   :compra/cartao          {:cartao/numero numero-cartao}})