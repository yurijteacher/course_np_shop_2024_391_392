<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><b>Apple+</b></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Головна</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/category">Каталог продукції</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/payment">Оплата</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/delivery">Доставка</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/info">Про компанію</a>
                </li>
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Пошук товарів" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Пошук</button>
                </form>
            </ul>


            <form method="get" action="/cart">
                <button class="btn btn-success me-2" type="submit"><i class="bi bi-cart"></i>
                    Кошик </button>
            </form>
        </div>
    </div>
</nav>