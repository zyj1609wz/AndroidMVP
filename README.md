# AndroidMVP
Android MVP架构demo

## 特点
- 基于 AndroidX
- 使用 Kotlin 语言
- 使用 Rxjava3 

## 分支介绍：

  - main = 精简 mvp 架构思想, 网络请求使用 retrofit
  
    如果你想快速了解 mvp 架构，请参照 main 分支
  
  - mvp-rxjva3 = mvp 架构 + rxjava3 混合使用
  
    如果你想了解 mvp 如何和 rxjava3 联合使用，请参数 mvp-rxjva3 分支
    
  - mvp-fragment : 在 main 分支的基础下， 完善对 Fragment mvp 支持，并且添加通用 UniversalPresenter 、UniversalModel
  
## 反思

这中架构的 Model 承载的业务太少了，有点鸡肋  