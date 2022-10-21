(ns alura-clojure.curso2)

(defn custom-map
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))))


(custom-map println (range 5000) )