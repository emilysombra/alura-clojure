(ns alura-clojure.aula)

(def estoque {:mochila 10
              :camiseta 5})

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 2, :preco 40}})

(defn desconto-aplicavel?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  [valor-bruto]
  (if (desconto-aplicavel? valor-bruto)
    (let [taxa-desconto (/ 10 100)
          desconto (* valor-bruto taxa-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(defn preco-produto [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(defn total-pedido
  [pedido]
  (->> pedido
      (map preco-produto)
      (reduce +)))
(println (valor-descontado 1000))

(def precos [30 70 1000])

(println (map valor-descontado precos))
(println (filter desconto-aplicavel? precos))
(println ( reduce + (map preco-produto pedido)))
(println (total-pedido pedido))