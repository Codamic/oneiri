(ns oneiri.views.home
  (:require [oneiri.views.grommet :refer [app]]
            [re-frame.core        :as re-frame]
            [oneiri.utils         :refer [dir-class]]))


(defn home
  ([]
   (let [lang (re-frame/subscribe [:lang])]
     ;; Content

     [app {:lang @lang
           :className  (dir-class @lang)
           :centered false}

      [:h1 @lang]]))
  ([children]))
