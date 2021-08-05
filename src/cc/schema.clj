(ns cc.schema
  (:require [schema.core :as s]))

(def Compra
  "Compra schema"
  {(s/required-key :data) java.util.Date, (s/required-key :valor) s/Num, (s/required-key :estabelecimento) s/Str, (s/required-key :categoria) s/Str})
