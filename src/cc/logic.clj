(ns cc.logic
  (:require [cc.db]))

(defn get-compras [cliente cartao]
  ((cc.db/compras (keyword (cliente :cpf))) (keyword (cartao :numero))))

(defn agrupar-compras-por-categoria [compras]
  (map
    (fn [[k v]]
      {:categoria k
       :total     (reduce + (map :valor v))})
    (group-by :categoria compras)))

(defn agrupar-compras-por-mes [compras]
  (map
    (fn [[k v]]
      {:mes   k
       :valor (reduce + (map :valor v))})
    (group-by cc.util/get-month-from-compra compras)))

