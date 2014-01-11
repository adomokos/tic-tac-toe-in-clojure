(ns tic-tac-toe.core
  (:gen-class))

(def board
  [[:_ :_ :_][:_ :_ :_][:_ :_ :_]])

(defn print-board [board]
  (let [print-board-line
    (fn [line]
      (apply str (map #(str (name %) " ") line)))]
  (str "\n"
    (apply str (map #(str (print-board-line %) "\n") board)))))

(defn record-player-move [step board]
  (let [x (- (first step) 1)
        y (- (last step) 1)]
    (-> board (assoc-in [x y] :X))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println (print-board)))
