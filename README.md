# SwipeRefreshExpandLayout
拓展自SwipeRefreshLayout. 支持自定义HeaderView和FooterView，支持下拉刷新和上拉加载更多

##支持的View
> 理论上支持所有的View
> 你也可以自定义自己喜欢的头部和尾部，插件试替换，非常简单哦！

##How to

- Step 1. 把 JitPack repository 添加到build.gradle文件中 repositories的末尾:
```
repositories {
    maven { url "https://jitpack.io" }
}
```
- Step 2. 在你的app build.gradle 的 dependencies 中添加依赖
```
dependencies {
	compile 'com.github.alafighting:SwipeRefreshExpandLayout:v0.0.1'
}
```

##致谢
- Google SwipeRefreshLayout
- dim
- [liaohuqiu android-Ultra-Pull-To-Refresh](https://github.com/liaohuqiu/android-Ultra-Pull-To-Refresh)
- [Yalantis Phoenix](https://github.com/Yalantis/Phoenix)
- [Aspsine SwipeToLoadLayout](https://github.com/Aspsine/SwipeToLoadLayout)
- [android-cjj MaterialRefreshLayout](https://github.com/android-cjj/Android-MaterialRefreshLayout)


##License

    Copyright 2015 alafighting. All rights reserved.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
