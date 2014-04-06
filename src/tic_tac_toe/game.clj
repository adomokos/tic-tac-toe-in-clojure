(ns tic-tac-toe.game)

(def board
  [[:_ :_ :_][:_ :_ :_][:_ :_ :_]])

(defn print-board [board]
  (let [print-board-line
        (fn [line]
          (apply str (map #(str (name %) " ") line)))]
  (str "\n"
    (apply str (map #(str (print-board-line %) "\n") board)))))

(defn converts-step-into-coordinates [step]
  (let [parsed-string (seq step)
        row (first parsed-string)
        col (last parsed-string)
        converted-row (fn []
                        (cond
                          (= row \A) 0
                          (= row \B) 1
                          :else 2))]
    [(converted-row) (-> col str Integer/parseInt dec)]))

(defn record-move [board step mark]
  (let [coordinates (converts-step-into-coordinates step)
        x (first coordinates)
        y (last coordinates)]
    (-> board (assoc-in [x y] mark))))
