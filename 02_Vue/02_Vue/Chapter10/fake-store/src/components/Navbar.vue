<template>
  <div>
    <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
      <div class="container-fluid">
        <ul class="navbar-nav">
          <li>
            <router-link class="nav-link" :to="{ name: 'home' }">
              <font-awesome-icon :icon="['fas', 'house']" /> Fake Store
            </router-link>
          </li>
          <li class="nav-item navbar-wide">
            <router-link class="nav-link" :to="{ name: 'electronics' }"
              ><font-awesome-icon :icon="['fas', 'tv']" /> 가전</router-link
            >
          </li>
          <li class="nav-item navbar-wide">
            <router-link class="nav-link" :to="{ name: 'jewelery' }"
              ><font-awesome-icon :icon="['fas', 'gem']" /> 주얼리</router-link
            >
          </li>
          <li class="nav-item navbar-wide">
            <router-link class="nav-link" :to="{ name: 'mensclothing' }"
              ><font-awesome-icon :icon="['fas', 'person']" /> 남성
              의류</router-link
            >
          </li>
          <li class="nav-item navbar-wide">
            <router-link class="nav-link" :to="{ name: 'womenclothing' }"
              ><font-awesome-icon :icon="['fas', 'person-dress']" /> 여성
              의류</router-link
            >
          </li>
        </ul>
        <ul class="navbar-nav">
          <li class="nav-item navbar-small">
            <font-awesome-icon :icon="['fas', 'bars']" style="color: white" />
          </li>
        </ul>
      </div>
    </nav>
  </div>
</template>

<script setup></script>

<style scoped>
.navbar-small {
  display: none;
}

@media screen and (max-width: 768px) {
  .navbar-small {
    display: inline;
  }
  .navbar-wide {
    display: none;
  }
}
</style>
