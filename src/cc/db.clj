(ns cc.db)

(def cliente {:nome "Allan Fernando", :cpf "12345678909", :email "allan@allan.com"})

(def cartao {:numero "1111222233334444", :cvv "246", :validade "12/2030", :limite 10000.00M})

(def compras {})

(defn update-compras [compras]
   (def compras compras))

