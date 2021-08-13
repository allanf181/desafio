(ns cc.schema
  (:require [schema.core :as s]))

(def Compra
  "Compra schema"
  {(s/required-key :data) java.util.Date, (s/required-key :valor) s/Num, (s/required-key :estabelecimento) s/Str, (s/required-key :categoria) s/Str})

(def schema [
             ;; cliente
             {:db/ident       :cliente/nome
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "O nome do cliente"}
             {:db/ident       :cliente/cpf
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/unique      :db.unique/identity
              :db/doc         "O CPF do cliente"}
             {:db/ident       :cliente/email
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "O E-mail do cliente"}
             ;; cartão
             {:db/ident       :cartao/numero
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/unique      :db.unique/identity
              :db/doc         "O número do cartão"}
             {:db/ident       :cartao/cvv
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "O CVV do cartão"}
             {:db/ident       :cartao/validade
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "A validade do cartão"}
             {:db/ident       :cartao/limite
              :db/valueType   :db.type/bigdec
              :db/cardinality :db.cardinality/one
              :db/doc         "O limite do cartão"}
             {:db/ident       :cartao/cliente
              :db/valueType   :db.type/ref
              :db/cardinality :db.cardinality/one
              :db/doc         "O cliente a quem o cartão pertence"}
             ;; compra
             {:db/ident       :compra/id
              :db/valueType   :db.type/uuid
              :db/cardinality :db.cardinality/one
              :db/doc         "O uuid da compra"}
             {:db/ident       :compra/data
              :db/valueType   :db.type/instant
              :db/cardinality :db.cardinality/one
              :db/doc         "A data da compra"}
             {:db/ident       :compra/valor
              :db/valueType   :db.type/bigdec
              :db/cardinality :db.cardinality/one
              :db/doc         "O valor da compra"}
             {:db/ident       :compra/estabelecimento
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "O estabelecimento da compra"}
             {:db/ident       :compra/categoria
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc         "A categoria da compra"}
             {:db/ident       :compra/cartao
              :db/valueType   :db.type/ref
              :db/cardinality :db.cardinality/one
              :db/doc         "O cartão usado na compra"}])
