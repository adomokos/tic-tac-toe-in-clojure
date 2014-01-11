(ns tic-tac-toe.core
  (:gen-class))

(def board
  [[:_ :_ :_][:_ :_ :_][:_ :_ :_]])

(defn print-board []
  (let [print-board-line
    (fn [line]
      (apply str (map #(str (name %) " ") line)))]
  (str "\n"
    (apply str (map #(str (print-board-line %) "\n") board)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println (print-board)))
