(ns oneiri.views.home
  (:require [oneiri.views.grommet :refer [app box columns]]
            [re-frame.core        :as re-frame]
            [oneiri.views.articles :refer [articles-list]]
            [oneiri.utils         :refer [dir-class]]
            [oneiri.views.navbar  :refer [navbar]]))

(defn home
  ([]
   (home (articles-list)))
  ([children]
      (let [lang (re-frame/subscribe [:lang])]
     ;; Content
     [app {:lang @lang
           :className  (dir-class @lang)
           :centered false}

      [navbar @lang]

      [box {:pad "large"}
       children]])))
