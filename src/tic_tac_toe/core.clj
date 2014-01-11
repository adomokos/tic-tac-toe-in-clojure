(ns tic-tac-toe.core
  (:gen-class))

(def board
  [[:_ :_ :_][:_ :_ :_][:_ :_ :_]])

(defn print-board []
  (str "\n"
    (apply str (map #(str (name %) " ") (first board)))
    "\n"
    (apply str (map #(str (name %) " ") (second board)))
    "\n"
    (apply str (map #(str (name %) " ") (last board)))
    "\n"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!"))
