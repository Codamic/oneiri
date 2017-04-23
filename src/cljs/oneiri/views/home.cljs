(ns oneiri.views.home
  (:require [oneiri.views.grommet :refer [app]]
            [re-frame.core :as re-frame]))


(defn home
  ([]
   (let [lang (re-frame/subscribe [:lang])]
     ;; Content
     (js/console.log "asdasdasdasd")
     [app {:lang @lang
           :className  (if (= @lang :en) "ltr" "rtl")
           :centered false}
      [:h1 "HI"]]))
  ([children]))
