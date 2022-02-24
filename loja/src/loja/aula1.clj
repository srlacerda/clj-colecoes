(ns loja.aula1)

; ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"] -> vetor
; {"guilherme" 37, "paulo" 39} -> mapa
; '(1 2 3 4 5) -> lista ligada
; [[0 1]]
; #{} -> conjunto

; map
; reduce
; filter

; loop
; for

(map println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(println (first ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (rest ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (rest []))
(println (next ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (next []))                                         ;-> retorna nil, pode ser usado para descobrir quando acabou
(println (seq []))
(println (seq [1 2 3 5]))                                   ; -> de vetor para sequencia
;println  ["guilherme" "carlos" "paulo" "lucia" "ana"]
;println  ["carlos" "paulo" "lucia" "ana"]
;println  ["paulo" "lucia" "ana"]
;...
;println []

(println "\n\n\n\nMEU MAPA")

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)
    (meu-mapa funcao (rest sequencia))))

;(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])




(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if primeiro
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))))

(println "\n\n\n\nMEU MAPA com parada")

(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])




(println "\n\n\n\nMEU MAPA com parada no nil")

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))))




(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])
(meu-mapa println [])
(meu-mapa println nil)

;(meu-mapa println (range 1000000))




(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))))

(meu-mapa println (range 5000))

; funcao:
;   situacao inicial
;   for 1 : 1 to 5000
;     outra-variavel =
;     outra-outra-variavel =
;   situacao final


; NAO EH TAIL, NAO PODE!!!
; (defn meu-mapa
; [funcao sequencia]
; (let [primeiro (first sequencia)]
; (if (not (nil? primeiro))
; (do
; (recur funcao (rest sequencia))
;  (funcao primeiro)) ) ) )