(ns oneiri.views.articles
  (:require [re-frame.core        :as re-frame]
            [oneiri.logger        :as logger]
            [oneiri.views.grommet :refer [title anchor glist list-item icon box]]
            [reagent.core         :as r]))


(defn render-article
  "Render a single article"
  [article]
  [list-item {:justify "between"} ^{:key article}
   [title
    (:title article)]
   [anchor {:href  "//github.com"
            :icon  (icon "LinkNext")
            :label (:title article)
            :primary true}]])


(defn articles-list
  "This view is responsible for rendering a list of articles."
  []
  (let [articles (re-frame/subscribe [:recent-articles])]
    [box {:size :full :alignSelf :stretch}
     [glist {:selectable true :onSelect (fn [_] (js/alert ";)"))}
      (for [article @articles]
        ^{:key (:id article)} [render-article article])]]))
