(ns app)

(js/log "Hello, world 2")

(inc 1)
(map inc [1 2 3])
(.getElementById js/document "app")

;; (js/alert "Hello, world!")
(defn avg [a b]
  (/ (+ a b) 2.0))

(+ 1 2)